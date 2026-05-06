const careers = {
  tech: {
    name: "Software Engineer 💻",
    salary: "₹4L – ₹20L+",
    difficulty: "High",
    creativity: "Medium"
  },
  design: {
    name: "UI/UX Designer 🎨",
    salary: "₹3L – ₹15L",
    difficulty: "Medium",
    creativity: "High"
  },
  service: {
    name: "Healthcare / Social Work ❤️",
    salary: "₹2L – ₹10L",
    difficulty: "High",
    creativity: "Low"
  }
};

let result = localStorage.getItem("careerResult");

// Decide second career (backup)
let second = "design";
if(result === "design") second = "tech";
if(result === "service") second = "tech";

// Fill first career
document.getElementById("career1").innerText = careers[result].name;
document.getElementById("salary1").innerText = "Salary: " + careers[result].salary;
document.getElementById("difficulty1").innerText = "Difficulty: " + careers[result].difficulty;
document.getElementById("creativity1").innerText = "Creativity: " + careers[result].creativity;

// Fill second career
document.getElementById("career2").innerText = careers[second].name;
document.getElementById("salary2").innerText = "Salary: " + careers[second].salary;
document.getElementById("difficulty2").innerText = "Difficulty: " + careers[second].difficulty;
document.getElementById("creativity2").innerText = "Creativity: " + careers[second].creativity;

// Recommendation logic
let recommendation = "";

if(result === "tech"){
  recommendation = "Choose Software Engineer if you enjoy logic. Choose Design if you prefer creativity.";
}
else if(result === "design"){
  recommendation = "Choose Design if you love creativity. Choose Tech if you want higher salary potential.";
}
else{
  recommendation = "Choose Service if you enjoy helping people. Choose Tech for more technical work.";
}
document.querySelectorAll(".compare-card")[0].classList.add("highlight");

document.getElementById("recommendation").innerText = recommendation;

function goBack(){
  window.location.href = "result.html";
}