const apiKey = '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;' // Replace with your actual API key
const chatLog = document.getElementById('chat-log');
const messageInput = document.getElementById('message-input');
const sendButton = document.getElementById('send-button');

sendButton.addEventListener('click', sendMessage);

messageInput.addEventListener('keypress', function (event) {
    if (event.key === 'Enter') {
        event.preventDefault(); // Prevent the Enter key from submitting the form
        sendMessage(); // Call the sendMessage function when Enter is pressed
    }
});

async function sendMessage() {
    const message = messageInput.value.trim();
    if (message === '') return;

    appendMessage('user', message);
    messageInput.value = '';

    const response = await fetchOpenAIResponse(message);
    appendMessage('ai', response.choices[0].message.content);

}

async function fetchOpenAIResponse(message) {
    try {
        const response = await fetch('https://api.openai.com/v1/chat/completions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer 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`
            },
            body: JSON.stringify({
                model: 'gpt-3.5-turbo',
                messages: [{ role: 'user', content: message }],
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const responseData = await response.json();
        console.log('API Response:', responseData);
        return responseData;
    } catch (error) {
        console.error('Error fetching API response:', error);
        return { choices: [{ message: { content: 'An error occurred.' } }] };
    }
}

function scrollToBottom() {
    chatLog.scrollTop = chatLog.scrollHeight;
}

function handleOverflowScroll() {
    if (chatLog.scrollHeight > chatLog.clientHeight) {
        scrollToBottom();
    }
}

function appendMessage(role, content) {
    const messageDiv = document.createElement('div');
    messageDiv.className = role === 'user' ? 'user-message' : 'ai-message';
    messageDiv.textContent = content;

    // Insert the message at the beginning of the chat log
    chatLog.appendChild(messageDiv);

    handleOverflowScroll();
}

async function sendMessage() {
    const message = messageInput.value.trim();
    if (message === '') return;

    appendMessage('user', message);
    messageInput.value = '';

    const response = await fetchOpenAIResponse(message);
    appendMessage('ai', response.choices[0].message.content);
}
