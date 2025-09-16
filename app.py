import streamlit as st

# Title and description
st.title("📊 Customer Retention Predictor")
st.write("Enter customer details below to predict whether they are likely to stay or leave.")

# Inputs
tenure = st.number_input("Tenure (months)", min_value=0, max_value=100, step=1)
contract = st.selectbox("Contract Type", ["Month-to-Month", "One-Year", "Two-Year"])
charges = st.number_input("Monthly Charges ($)", min_value=0.0, step=1.0)

# Prediction logic
def get_prediction(tenure, contract, charges):
    if contract == "Month-to-Month" and charges > 70 and tenure < 12:
        return "❌ Likely to Leave"
    elif contract == "Two-Year" or tenure > 24:
        return "✅ Likely to Stay"
    elif charges < 50:
        return "✅ Likely to Stay"
    else:
        return "⚠️ Medium Risk"

# Button to predict
if st.button("Predict"):
    result = get_prediction(tenure, contract, charges)
    st.success(f"Prediction: {result}")
