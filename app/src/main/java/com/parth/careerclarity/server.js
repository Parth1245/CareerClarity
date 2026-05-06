import express from "express";
import fetch from "node-fetch";
import cors from "cors";

const app = express();
app.use(cors());
app.use(express.json());

const API_KEY = "YOUR_OPENAI_API_KEY"; // 🔴 replace this

app.post("/ask", async (req, res) => {
  const userMessage = req.body.message;

  try {
    const response = await fetch("https://api.openai.com/v1/responses", {
      method: "POST",
      headers: {
        "Authorization": `Bearer ${API_KEY}`,
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        model: "gpt-4.1-mini",
        input: userMessage
      })
    });

    const data = await response.json();

    res.json({
      reply: data.output?.[0]?.content?.[0]?.text || "No response"
    });

  } catch (err) {
    res.status(500).json({ reply: "Error connecting to AI" });
  }
});

app.listen(3000, () => console.log("Server running on port 3000"));