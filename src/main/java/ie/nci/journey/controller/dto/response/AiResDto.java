package ie.nci.journey.controller.dto.response;

import java.util.Date;

/**
 * AiResponse
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
public class AiResDto {
    private String text;
    private Date timestamp;

    public AiResDto() {
    }

    public AiResDto(String text, Date timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
