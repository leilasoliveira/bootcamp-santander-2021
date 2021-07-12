package digital.innovation.one;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClientHttp {

    /*
     * HTTP 1.1
     * - Chama uma conexão, manda requisição e espera uma resposta.
     * - Valor fixo de conexões pra executar requisições.
     *
     * HTTP 2.0 - Multiplexação
     * - Numa mesma conexão, consegue mandar várias requisições de forma concorrente.
     * - Requisições são transformadas em stream de frames.
     * - Desta forma, aumenta a performance da aplicação.
     * - Chega a ser 4x mais rápida que HTTP 1.1.
     *
     * Se o server suportar HTTP 2.0 é que isso funciona, não apenas se o cliente for HTTP 2.0.
     *
     * */

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            // daemon: threads que não impedem a jvm finalizar, exemplo garbage colletor.
            System.out.println("Nova thread criada :: " +
                    (thread.isDaemon() ? "daemon" : "Thread Group :: " + thread.getThreadGroup()));
            return thread;
        }
    });

    public static void main(String[] args) throws IOException, InterruptedException {
        //testNovaApiHttpClientJava11();
        connectAkamaiHttp11Client(HttpClient.Version.HTTP_1_1);
        connectAkamaiHttp11Client(HttpClient.Version.HTTP_2);
    }

    /**
     * Conecta ao servidor Akamai HTTP 1.1 ou 2
     */
    private static void connectAkamaiHttp11Client(HttpClient.Version version) {
        System.out.println("Running " + version.name() + " example...");

        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(version)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code ::: " + response.statusCode());
            System.out.println("Response headers ::: " + response.headers());
            String responseBody = response.body();
            //System.out.println("Response responseBody ::: " + responseBody);

            List<Future<?>> futures = new ArrayList<>();
            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imageFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com" + image))
                                    .build();
                            try {
                                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                //System.out.println("Imagem Carregada :: " + image + " , status code :: " + imageResponse.statusCode());
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                        futures.add(imageFuture);
                        System.out.println("Submetido um futuro para imagem :: " + image);
                    });

            futures.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });

            long end = System.currentTimeMillis();

            System.out.println(version.name() + " - Tempo de carregamento total: " + (end - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //executor.shutdown();
        }
    }

    private static void testNovaApiHttpClientJava11() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code response: " + response.statusCode());
        System.out.println("Headers response: " + response.headers());
        System.out.println(response.body());
    }

}
