package ie.nci.journey.controller.dto.request;

import java.util.List;

/**
 * AiReqDto
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-10
 */
public class AiReqDto {
    private List<Entity> messages;

    public static class Entity {
        private String role;
        private String content;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public List<Entity> getMessages() {
        return messages;
    }

    public void setMessages(List<Entity> messages) {
        this.messages = messages;
    }
}
