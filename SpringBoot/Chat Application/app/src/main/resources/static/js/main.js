let usernamePage = document.querySelector("#username-page");
let chatpage = document.querySelector("#chat-page");
let usernameForm = document.querySelector("#usernameForm");
let usernameInputElement = document.querySelector("#name");
let connectingElementDiv = document.querySelector(".connecting");
let messageArea = document.querySelector("#messageArea");
let messageForm = document.querySelector("#messageForm");
let messageInputElement = document.querySelector("#message");

let stompClient = null;
let username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    event.preventDefault();
    username = usernameInputElement.value.trim();
    if(username) {
        usernamePage.classList.add("hidden");
        chatpage.classList.remove("hidden");
        let socket = new SockJS("/ws");
        stompClient = Stomp.over(socket);
        
        stompClient.connect({}, onConnected, onError);
    }
}

function onConnected() {
    // subscribe 
    stompClient.subscribe("/topic/public", onMessageReceived);
    // send initial joining message
    stompClient.send("/app/chat.addUser", {}, JSON.stringify({
        sender: username,
        type: 'JOIN'
    }));

    // hide the connecting div element
    connectingElementDiv.classList.add("hidden");
}

function onError() {
    connectingElementDiv.textContent = "Error while connecting. Please try again after sometime!";
    connectingElementDiv.computedStyleMap.color = "red";
}

function onMessageReceived(payload) {
    // get message from body
    let message = JSON.parse(payload.body);

    // create a list element to be shown in messages unordered list
    let messageElement = document.createElement("li");

    // act based on the type of the message
    if(message.type === 'JOIN') {
        messageElement.classList.add("event-message");
        message.content = message.sender + " joined!";
    }
    else if (message.type === 'LEAVE') {
        messageElement.classList.add("event-message");
        message.content = message.sender + " left!";
    }
    else {
        messageElement.classList.add("chat-message");

        let avatarElement = document.createElement("i");
        let avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['backgroundColor'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        let usernameElement = document.createElement("span");
        let usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        
        messageElement.appendChild(usernameElement);
    }

    let textElemenet = document.createElement("p");
    let messageTextContent = document.createTextNode(message.content);
    textElemenet.appendChild(messageTextContent);

    messageElement.appendChild(textElemenet);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}

function getAvatarColor(username) {
    let hash = 0;
    for(let i = 0; i < username.length; i++) {
        hash = hash * 31 + username.charCodeAt(i);
    }
    const index = Math.abs(hash) % colors.length;
    return colors[index];
}

function sendMessage(event) {
    event.preventDefault();
    let message = messageInputElement.value.trim();
    if(message && stompClient) {
      //  let username = usernameInputElement.value.trim();
        let chatMessage = {
            sender: username,
            content: message,
            type: 'CHAT'
        }
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInputElement.value = "";
    }
}

usernameForm.addEventListener("submit", connect, true);
messageForm.addEventListener("submit", sendMessage, true);