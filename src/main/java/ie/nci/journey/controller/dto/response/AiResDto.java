package ie.nci.journey.controller.dto.response;

/**
 * AiResponse
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
public class AiResDto {
    private String text;
    private String timestamp;

    public AiResDto() {
    }

    public AiResDto(String text, String timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
