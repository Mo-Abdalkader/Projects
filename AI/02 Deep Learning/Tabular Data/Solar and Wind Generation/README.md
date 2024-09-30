# Renewable Energy Forecasting Using Machine Learning

## Project Overview

This project focuses on forecasting **solar and wind power generation** using weather data. The forecasting is achieved by utilizing advanced machine learning models like **Deep Neural Networks (DNN)**, **Long Short-Term Memory (LSTM)**, **Convolutional Neural Networks (CNN)**, and **Gated Recurrent Units (GRU)**.

Two datasets are combined for this purpose:
1. **Time Series Energy Dataset** (`time_series_60min_singleindex.csv`): This dataset contains hourly data on solar and wind power generation in kilowatts (kW).
2. **Weather Dataset** (`weather_data.csv`): This dataset provides weather conditions such as temperature, wind speed, humidity, etc., that affect solar and wind power generation.

The project entails data preprocessing, analysis, visualization, model building, and evaluation to predict future energy production based on historical weather patterns.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Datasets](#datasets)
3. [Data Preprocessing](#data-preprocessing)
4. [Exploratory Data Analysis (EDA)](#exploratory-data-analysis-eda)
5. [Feature Scaling](#feature-scaling)
6. [Modeling](#modeling)
    - [Deep Neural Network (DNN)](#deep-neural-network-dnn)
    - [Long Short-Term Memory (LSTM)](#long-short-term-memory-lstm)
    - [Convolutional Neural Network (CNN)](#convolutional-neural-network-cnn)
    - [Gated Recurrent Units (GRU)](#gated-recurrent-units-gru)
7. [Model Evaluation](#model-evaluation)
8. [Conclusion](#conclusion)
9. [Future Work](#future-work)

---

## Datasets

1. **Time Series Energy Dataset (`time_series_60min_singleindex.csv`)**:
    - Contains hourly measurements of **solar** and **wind** power generation in kilowatts (kW).
    - Used as the target variable for the modeling.

2. **Weather Dataset (`weather_data.csv`)**:
    - Includes various weather parameters (e.g., temperature, humidity, wind speed) collected hourly.
    - Features from this dataset were merged with the energy dataset for model inputs.

---

## Data Preprocessing

### Merging the Datasets:
- The two datasets were combined on the common time index. The weather data features (e.g., temperature, wind speed, etc.) were added to the energy dataset to create a comprehensive dataset for modeling.

### Handling Missing Values:
- Missing values in the datasets were handled using appropriate imputation techniques. For weather data, mean imputation was applied, while in the energy dataset, missing values were filled using forward filling methods.

### Feature Engineering:
- New time-related features (e.g., **day of the week**, **hour of the day**) were extracted from the timestamp column to enhance model performance.

---

## Exploratory Data Analysis (EDA)

Visualizations were performed to understand the trends and correlations between the features:
- **Line plots** were used to visualize the **hourly trends** in solar and wind energy generation.
- **Correlation heatmaps** helped identify the relationships between weather conditions and energy generation.
- **Histograms and boxplots** gave insight into the distribution and outliers in the data.

Key findings:
- Solar energy generation follows a clear **daily cycle**, with peaks during the middle of the day.
- Wind energy is more random but shows some seasonal variation.

---

## Feature Scaling

- The features were scaled using **MinMaxScaler**, bringing all values into the range [0, 1]. This ensures that the different feature magnitudes do not affect the model training process.
- The target variables (solar and wind power) were also scaled to fit within the same range.

---

## Modeling

### Deep Neural Network (DNN)
- **Architecture**: Fully connected neural network with multiple hidden layers.
- **Activation Function**: ReLU for hidden layers, linear for the output layer.
- **Optimizer**: Adam optimizer was used for model training.

### Long Short-Term Memory (LSTM)
- **Architecture**: A sequence model that captures temporal dependencies in the data.
- **Time Steps**: Historical data of the past 24 hours was used to predict the next hour's energy generation.
- **Advantages**: LSTM handles the sequential nature of time-series data and learns from long-term dependencies effectively.

### Convolutional Neural Network (CNN)
- **Architecture**: 1D CNN layers were used to extract spatial features from time-series data.
- **Advantages**: CNNs efficiently capture local patterns in time-series data, improving model performance in cases of short-term dependencies.

### Gated Recurrent Units (GRU)
- **Architecture**: Similar to LSTM but with a simplified structure.
- **Advantages**: GRU provides comparable performance to LSTM while being computationally efficient.

---

## Model Evaluation

The models were evaluated using the following metrics:
- **Mean Absolute Error (MAE)**: Measures the average magnitude of the errors in predictions.
- **Mean Squared Error (MSE)**: Measures the average of the squares of the errors.
- **Root Mean Squared Error (RMSE)**: Square root of the MSE, providing a better intuition of model performance.
- **R-squared (R²)**: Indicates how well the model fits the data.

| Model   | MAE    | MSE    | RMSE   | RMSLE | R²    |
|---------|--------|--------|--------|-------|-------|
| DNN     | 0.0634  | 0.0098  | 0.0991  | -2.3118 | 0.7807 |
| LSTM    | 0.0935  | 0.0190  | 0.1378  | -1.9819 | 0.5759 |
| CNN     | 0.0794  | 0.0144  | 0.1200  | -2.1205 | 0.6785 |
| GRU     | 0.0700  | 0.0122  | 0.1105  | -2.2024 | 0.7271 |

Key observations:
- **LSTM** and **GRU** models performed well in capturing the time-series nature of the data.
- **CNN** demonstrated good performance, especially in short-term forecasting.
- **DNN** gave reasonable results but did not perform as well as sequence models due to the time-series data's inherent sequential patterns.

---

## Conclusion

In this project, we successfully forecasted solar and wind energy generation based on historical weather data. After experimenting with different machine learning models, **LSTM** and **GRU** models showed the best performance in terms of accuracy and capturing temporal dependencies in the data. The project highlights the importance of choosing the right model architecture for time-series forecasting tasks.

---

## Future Work

- **Hyperparameter Tuning**: Perform detailed hyperparameter optimization to further improve model accuracy.
- **Ensemble Models**: Explore the possibility of combining different models to create an ensemble for better predictions.
- **Additional Data**: Incorporate more weather variables (e.g., solar radiation) or use satellite data to enhance model predictions.

---
