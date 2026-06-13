import pandas as pd
import matplotlib.pyplot as plt

# DataFrame - it is a 2-dimensional data structure in pandas which has column labels, indexes and data
# 1. By default, index for rows in DataFrame start with 0
# 2. Each column in DataFrame known as series
df = pd.DataFrame({
    "Name": [
        "Passenger 1", "Passenger 2", "Passenger 3"
    ],
    "Age": [23, 25, 27],
    "Gender": ["Male", "Male", "Female"]
})
# print(df)
# Accessing particular column data
# print(df["Age"])

# Creating a Series from scratch
ages = pd.Series([18, 19, 20], name="Age")
# print(ages) # Series doesn't have column label, it have row labels

# Find Maximum age
# print(df["Age"].max()) # 27
# print(ages.max()) # 20

# Describe the numerical data in the table
# print(df.describe())

# reading the csv file
titanic = pd.read_csv("data/Titanic.csv")
# print(titanic)

# reading first 10 rows of DataFrame
# print(titanic.head(10))

# reading last 10 rows of DataFrame
# print(titanic.tail(10))

# checking datatypes of DataFrame
# dtypes - is a attribute of DataFrame, it doesn't need parenthesis
# print(titanic.dtypes)

# read_* methods are used to read data from various file formats
# write_* methods are used to write data to various file formats
# write DataFrame to excel
# titanic.to_excel("data/Titanic.xlsx", sheet_name="passengers", index=False)

# reading excel file
# titanic = pd.read_excel("data/Titanic.xlsx", sheet_name="passengers")
# print(titanic.head())

# information about the DataFrame
# print(titanic.info())

# print(titanic.head())
# Selecting subset of DataFrame
ages = titanic["Age"]
# print(ages)
# print(type(ages))
# shape of Series
# print(ages.shape)
# shape of DataFrame - the columns label excluded in row dimension & row labels excluded in col dimension
# print(titanic.shape)

# Selecting two columns
age_gender = titanic[["Age", "Sex"]]
# print(age_gender)
# print(type(age_gender))
# print(age_gender.shape)

# Filtering specific rows from DataFrame
# all passengers above 35
above_35 = titanic[titanic["Age"] > 35]
# print(above_35)

survived = titanic["Survived"] == 1
# print(survived)
# print(type(survived))
# filter rows in DataFrame based on boolean values
# print(titanic[survived])
# print(titanic[survived].shape)
class_2_3 = titanic[titanic["Pclass"].isin([2, 3])]
# print(class_2_3)
class_2_3 = titanic[(titanic["Pclass"] == 2) | (titanic["Pclass"] == 3)]
# print(class_2_3)

# find the passengers whose age is not null
age_not_null = titanic[titanic["Age"].notna()]
# print(age_not_null)

# Select specific rows and columns
# Names of passengers whose age > 35
passengers_names = titanic.loc[titanic["Age"] > 35, "Name"]
# print(passengers_names)
# loc & iloc - helps in filtering rows & columns together
# syntax = data.loc[rowFilter, columnFilter]
#          data.iloc[rowFilter, columnFilter]
# use loc - when you want to filter using row labels, column labels, conditional expressions
# use iloc - when you filter using integer positions
# row & column filter can be a single label, list of labels, slice of labels, conditional expression or colon to
# select all rows or columns

# fetching rows 10 to 25 and cols 3 to 5
# print(titanic.dtypes)
# print(titanic.iloc[9:25, 2:5])

# assigning data to the selected rows & cols
titanic.iloc[:3, 3] = "anonymous"
# print(titanic.iloc[:5, 3])

# Creating plots
air_quality = pd.read_csv("data/air_quality.csv", index_col=0, parse_dates=True)
# print(air_quality)
# print(air_quality.dtypes)
# air_quality.plot()
# plt.show()

# plotting the data of a particular column
# air_quality["station_paris"].plot()
# plt.show()
# plot() works for both Series(single column) & DataFrame(multiple columns)

# scatter plot
# air_quality.plot.scatter(x="station_london", y="station_paris", alpha=0.5)
# plt.show()

# box plot
# air_quality.plot.box();
# plt.show()

# subplots
# air_quality.plot.area(figsize=(12, 4), subplots=True)
# plt.show()

# Create new columns derived from existing columns
# print(air_quality.head())
air_quality["london_mg_per_cube"] = air_quality["station_london"] * 1.882
# print(air_quality.head())
air_quality["ratio_paris_antwerp"] = ( air_quality["station_paris"] / air_quality["station_antwerp"] )
# print(air_quality.head())

# rename column names
air_quality_renamed = air_quality.rename(
    columns={
        "station_antwerp": "antwerp",
        "station_paris": "paris",
        "station_london": "london",
        # "london_mg_per_cube": "london_mg_per_cube",
        # "ratio_paris_antwerp": "ratio_paris_antwerp"
    }
)
# print(air_quality_renamed.head())

# Summary statistics
# print(titanic.head())

# average age of titanic passengers
# print(titanic["Age"].mean())

# median age and ticket fare
# print(titanic[["Age", "Fare"]].median())

# all aggregating statistics applied to multiple columns
# print(titanic[["Age", "Fare"]].describe())

# specifying the required aggregate functions in DataFrame
# print(titanic.agg({
#     "Age": ["min", "max"],
#     "Fare": ["min", "max"]
# }))

# Aggregation statistics grouped by category
# average age of male v/s female
# print(titanic[["Sex", "Age"]].groupby("Sex").mean())

# total number of males & females survived
# print(titanic.loc[titanic["Survived"] == 1, ["Sex", "Survived"]].groupby("Sex").sum())

# column selection on groupby
# print(titanic.groupby("Sex")["Age"].mean())

# mean fare for each sex and cabin class
# print(titanic.groupby(["Sex", "Pclass"])["Fare"].mean())

# Count number of records by category
# total number of people in each class
# print(titanic["Pclass"].value_counts())

# Reshape the layout of tables
# reshape means - we can change the structure of the table
# sort table rows based on a column value
sorted_by_age = titanic.sort_values(by="Age")
# print(sorted_by_age.head())

# sort titanic rows based on 'Pclass' and 'Age' in descending order
# print(titanic.sort_values(["Pclass", "Age"], ascending=False).head())

# read the new air quality data
air_quality = pd.read_csv("data/air_quality_long.csv")
# print(air_quality.head())

no2 = air_quality[air_quality["parameter"] == "no2"]
# print(no2.head())

# two records from each location, sorted by index
no2_subset = no2.sort_index().groupby(["location"]).head(2)
# print(no2_subset)

# values of the three columns as seperate columns
# print(no2_subset.pivot(columns="location", values="value"))