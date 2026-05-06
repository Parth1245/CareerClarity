const questions = [
  {
    q: "What do you enjoy more?",
    options: ["Solving problems", "Designing things", "Helping people"],
    scores: ["tech", "design", "service"]
  },
  {
    q: "Which subject do you like?",
    options: ["Math", "Art", "Biology"],
    scores: ["tech", "design", "service"]
  },
  {
    q: "What type of work do you prefer?",
    options: ["Logical tasks", "Creative work", "Social work"],
    scores: ["tech", "design", "service"]
  },
  {
    q: "What excites you?",
    options: ["Coding", "Drawing", "Helping others"],
    scores: ["tech", "design", "service"]
  }
];

let current = 0;
let score = {
  tech: 0,
  design: 0,
  service: 0
};

function loadQuestion() {
  let q = questions[current];
  document.getElementById("question").innerText = q.q;

  let optionsHtml = "";
  q.options.forEach((opt, index) => {
    optionsHtml += `
      <div>
        <input type="radio" name="option" value="${q.scores[index]}"> ${opt}
      </div>
    `;
  });

  document.getElementById("options").innerHTML = optionsHtml;
}

function nextQuestion() {
  let selected = document.querySelector('input[name="option"]:checked');

  if (!selected) {
    alert("Please select an option");
    return;
  }

  score[selected.value]++;

  current++;

  if (current < questions.length) {
    loadQuestion();
  } else {
    showResult();
  }
}

function showResult() {
  let result = "tech";

  if (score.design > score.tech && score.design > score.service) {
    result = "design";
  } else if (score.service > score.tech && score.service > score.design) {
    result = "service";
  }

  // Save full data (not just result)
  localStorage.setItem("careerResult", result);
  localStorage.setItem("scoreData", JSON.stringify(score));

  window.location.href = "result.html";
}
  localStorage.setItem("careerResult", result);
  window.location.href = "result.html";
}
optionsHtml += `
  <div onclick="selectOption('${q.scores[index]}')">${opt}</div>


loadQuestion();
let confidence = Math.max(score.tech, score.design, score.service) * 25;