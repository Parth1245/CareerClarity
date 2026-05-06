const chatBox = document.getElementById("chatBox");

function addMessage(text, type) {
  let div = document.createElement("div");
  div.style.margin = "8px 0";
  div.style.padding = "10px";
  div.style.borderRadius = "10px";

  if(type === "user"){
    div.style.background = "#4a90e2";
    div.style.color = "white";
    div.style.textAlign = "right";
  } else {
    div.style.background = "#eef4ff";
  }

  div.innerText = text;
  chatBox.appendChild(div);
  chatBox.scrollTop = chatBox.scrollHeight;
}

function sendMessage(){
  let input = document.getElementById("userInput");
  let msg = input.value.toLowerCase();

  if(msg === "") return;

  addMessage(msg, "user");
  input.value = "";

  setTimeout(() => {
    let reply = getReply(msg);
    addMessage(reply, "bot");
  }, 500);
}

function getReply(msg){

  if(msg.includes("confused")){
    return "That’s normal. Let’s simplify. What matters more to you: money, passion, or work-life balance?";
  }

  if(msg.includes("money")){
    return "Careers like Software Engineering usually offer higher salary growth.";
  }

  if(msg.includes("passion")){
    return "Choosing something you enjoy daily leads to long-term satisfaction.";
  }

  if(msg.includes("safe") || msg.includes("secure")){
    return "Stable careers include government jobs, healthcare, and engineering fields.";
  }

  if(msg.includes("design")){
    return "UI/UX Design is great if you enjoy creativity and visuals.";
  }

  if(msg.includes("tech") || msg.includes("coding")){
    return "Tech careers are growing fast and offer many opportunities.";
  }

  return "Tell me more about what you like or what confuses you.";
}

// Welcome message
addMessage("Hi 👋 I’m your AI guide. Ask me anything about your career.", "bot");