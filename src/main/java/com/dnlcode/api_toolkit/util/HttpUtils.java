package com.dnlcode.api_toolkit.util;

import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.List;

public class HttpUtils {
    /**
     * Extrae los headers de un HttpResponse como Map<String, List<String>>
     */
    public static Map<String, List<String>> extractHeaders(HttpResponse<?> response) {
        return response.headers().map();
    }

    /**
     * Reemplaza los parámetros de ruta en una URL usando el map pathParams.
     * Ejemplo: /users/{userId}/orders/{orderId}
     */
    public static String buildUrlWithPathParams(String urlTemplate, Map<String, String> pathParams) {
        if (pathParams == null) return urlTemplate;

        // Validar que todos los placeholders de la plantilla tengan valor en el mapa
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\{([^}]+)\\}").matcher(urlTemplate);
        while (matcher.find()) {
            String key = matcher.group(1);
            if (!pathParams.containsKey(key)) {
                throw new IllegalArgumentException("Falta el parámetro de ruta '" + key + "' en el mapa.");
            }
        }

        // Validar que no haya claves extra en el mapa
        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            String placeholder = "{" + entry.getKey() + "}";
            if (!urlTemplate.contains(placeholder)) {
                throw new IllegalArgumentException("Path param '" + entry.getKey() + "' no coincide con la plantilla de la URL.");
            }
            urlTemplate = urlTemplate.replace(placeholder, entry.getValue());
        }
        return urlTemplate;
    }
    
    /**
     * Agrega los query params a la URL, codificando los valores.
     */
    public static String buildUrlWithQueryParams(String url, Map<String, String> queryParams) {
        if (queryParams == null || queryParams.isEmpty()) return url;
        StringBuilder sb = new StringBuilder(url);
        sb.append(url.contains("?") ? "&" : "?");
        queryParams.forEach((key, value) -> {
            sb.append(URLEncoder.encode(key, StandardCharsets.UTF_8))
              .append("=")
              .append(URLEncoder.encode(value, StandardCharsets.UTF_8))
              .append("&");
        });
        // Elimina el último '&'
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}