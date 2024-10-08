package ie.nci.journey.controller.dto;

/**
 * ApiResponse
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
public class Response<T> {
    private int status;
    private String message;
    private T data;

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(200);
        response.setMessage("Success");
        return response;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> response = new Response<>();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> error(String message) {
        Response<T> response = new Response<>();
        response.setStatus(500);
        response.setMessage(message);
        return response;
    }

    public static <T> Response<T> error(int status, String message) {
        Response<T> response = new Response<>();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
