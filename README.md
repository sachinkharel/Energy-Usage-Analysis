# Energy-Usage-Analysis

- A program to help energy analysts identify annual electricity usage and usage trends during peak and off-peak periods.
- It helps analysts to know the maximum demand recorded in a year.
- Added a JavaFX layout for getting the input and display of results for a better user experience.

Input Format :
- A CSV file with electricity usage data in half an hour interval for 365 days.

Useful links:
- https://docs.oracle.com/javafx/2/charts/bar-chart.htm
- https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
- https://commons.apache.org/proper/commons-io/download_io.cgi

Methods Used:
- maxValue()
    - Itreates through all the values given in the CSV and outputs total usuage of the year, maximum value of the year and date of the maximum value.
- peakValues()
    - Itreates through the values between Mon-Fri ( 7 am - 11 pm ) which is considered as peak values. Stores all the peak values(usuage) according to the months.
- offPeakValues()
    - Itreates through the values all the values given in the CSV. Stores all the total values(usuage) according to the months.
    - Gives off peak values(usuage) (Total - Peak Values).
