import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ReverseGeocoding {

    public static void main(String[] args) {
        double latitude = 15.9064001;
        double longitude =  108.3472517;

        String address = getAddressFromCoordinates(latitude, longitude);

        if (address != null) {
            System.out.println("Địa chỉ: " + address);
        } else {
            System.out.println("Không tìm thấy địa chỉ hoặc có lỗi xảy ra.");
        }
    }

    public static String getAddressFromCoordinates(double latitude, double longitude) {
        String apiUrl = String.format("https://nominatim.openstreetmap.org/reverse?lat=%f&lon=%f&format=json", latitude, longitude);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();

                // Sử dụng thư viện Gson để phân tích JSON
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

                if (jsonObject != null && jsonObject.has("display_name")) {
                    return jsonObject.get("display_name").getAsString();
                } else {
                    return null; // Không tìm thấy địa chỉ
                }
            } else {
                System.err.println("Lỗi HTTP: " + response.statusCode());
                return null; // Lỗi khi gọi API
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null; // Lỗi kết nối hoặc phân tích JSON
        }
    }
}