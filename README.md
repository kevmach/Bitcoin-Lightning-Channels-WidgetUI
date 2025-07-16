# 🔍 Widget UI Test Suite

This repository contains end-to-end UI tests for the Blocktank Web Widget. The tests were written using **Selenium WebDriver** with **JUnit 5** in **Java** and focus on validating core user flows and edge cases.

---

## ✅ Test Coverage

### 1. **Channel Creation Flow**
- Inputs sats and expiry values
- Proceeds through the widget flow
- Verifies:
  - Terms acceptance
  - Pay button functionality
  - Lightning invoice text contains `"Invoice"`
  - On-chain tab shows `"Bitcoin Address"`

### 2. **Form Validation**
- Tries to proceed without entering required inputs
- Verifies error: `"Minimum receiving capacity is 100000 sats"`

### 3. **My Orders Navigation**
- Verifies that a customer can view their orders via the **"My Orders"** menu

### 4. **Payment Page Access**
- Verifies that a customer can proceed to the Payment Page from **"My Orders"**

---

## ⏳ Pending Test Cases
- Verifying that a customer can view **Terms of Service** before accepting
- Verifying that a customer can navigate to the **Settings** tab and select a preferred currency
- Verifying that the selected currency is retained when returning to the **Home Page**
- Verifying that a customer can navigate to the **Support** menu

---

## 🐞 Bugs & Issues Found

### 1. ⚠️ **Receiving Capacity Field**
- Loads default numbers on the initial home page view
- Might be confusing for potential customers who don’t understand what the field represents

### 2. 🔘 **Private Channel Toggle**
- No indication if this is a mandatory option for proceeding
- Could confuse users unfamiliar with Lightning channel requirements

---

## 🚀 How to Run the Tests

### 📦 Prerequisites
- Java 17+
- Maven or Gradle (if using a build tool)
- [GeckoDriver](https://github.com/mozilla/geckodriver/releases) installed and added to your system `PATH`
- Firefox browser installed

### 🔧 Setup & Run (Manual)
1. Clone the repository and open it in your IDE
2. Ensure `geckodriver` is accessible from your system environment
3. Run the tests using JUnit (via your IDE or a build tool like Maven/Gradle)
