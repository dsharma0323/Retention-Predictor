# Customer Retention Risk Checker

A lightweight interactive Streamlit app that uses **transparent, rule-based logic** to categorize potential customer retention risk. It is a learning project, not a trained machine-learning model or a validated prediction system.

## Live demo
[Try the Streamlit app](https://retention-predictor.streamlit.app)

## What it does
Enter a customer's:
- **Tenure:** number of months with the company (0–100)
- **Contract:** month-to-month, one-year, or two-year
- **Monthly charges:** dollar amount

Click **Predict** to receive one of three illustrative classifications: **Likely to Leave**, **Likely to Stay**, or **Medium Risk**.

## How the rules work
Rules are checked in this order:
1. Month-to-month contract, charges over $70, and tenure under 12 months → **Likely to Leave**
2. Otherwise, a two-year contract or tenure over 24 months → **Likely to Stay**
3. Otherwise, monthly charges under $50 → **Likely to Stay**
4. Otherwise → **Medium Risk**

These thresholds are illustrative assumptions; they were not learned from customer data. The output should not be treated as a reliable forecast for a real business.

## Run locally
```bash
python3 -m pip install -r requirements.txt
streamlit run app.py
```

## Tech stack
Python · Streamlit

## Product perspective
Retention risk is useful for prioritizing customer research and support outreach. A production version would require real labeled customer outcomes, careful validation, performance monitoring, and privacy safeguards.

## Next steps
- Gather appropriate historical customer data and define churn consistently.
- Evaluate whether the rules correspond to actual outcomes.
- Compare against a baseline model and assess false positives/negatives.
- Explain risk factors and test whether retention interventions help.
