class Message {
    constructor(role, content) {
        this.role = role;
        this.content = content;
    }
}

class MessageHistory {
    constructor(maxTotalLength) {
        this.maxTotalLength = maxTotalLength;
        this.messages = [];
        this.totalLength = 0;
    }

    // 添加新的用户问题和助手回答到历史记录
    addMessage(role, content) {
        const newMessage = new Message(role, content);
        const messageLength = this.calculateMessageLength(newMessage);

        // 如果加上新的消息不超过总字数限制，直接添加
        if (messageLength <= this.maxTotalLength) {
            this.messages.push(newMessage);
            this.totalLength += messageLength;
        } else {
            // 如果超过了总字数限制，移除最早的消息，直到满足条件
            while (this.totalLength + messageLength > this.maxTotalLength) {
                const removedMessage = this.messages.shift();
                this.totalLength -= this.calculateMessageLength(removedMessage);
            }

            this.messages.push(newMessage);
            this.totalLength += messageLength;
        }
    }

    // 计算消息的长度（字数）
    calculateMessageLength(message) {
        return message.content.length;
    }

    // 获取历史消息记录
    getHistory() {
        return { messages: this.messages };
    }
}

// 示例用法
const maxTotalLength = 3000;
const messageHistory = new MessageHistory(maxTotalLength);

// 添加新的用户问题和助手回答到历史记录
messageHistory.addMessage("user", "鱼香茄子怎么做？");
messageHistory.addMessage("assistant", "鱼香茄子的制作步骤如下：这样就可以做出美味的鱼香茄子啦！");
messageHistory.addMessage("user", "为什么没用鱼？");

// 获取历史消息记录
const history = messageHistory.getHistory();
console.log(history);
