# Retail-Data-Analysis
The objective of this project is to analyze Retail-Dataset and solve various KPIs of using **Apache Spark**.

### Data Format: tab delimited
` Data  Time   City   Product-category Sales   Payment-mode `

### Prerequisites:
Any flavor of linux with following installed:
  - JDK 8
  - Spark 2.4
  - Scala 2.11.x  
   
   
## KPIs
**KPI 1** 
  - Find product wise sales distribution.
  ```scala
  val breaking  = data.map{lst => 
     { 
       val tokens = lst.split("\t")
      
       val product = tokens(3)
       val sales = tokens(4)
      (product,Double.parseDouble(sales))  //product as key and sales as value
           
     }}
     .reduceByKey(_+_)    //reduceByKey((a,b) => a+b)
  ```
  
**KPI 2**
  - Find store wise sales.
  ```scala
  val result = data.map{line=>{
     
     val tokens = line.split("\t")
     
     (tokens(2), Double.parseDouble(tokens(4)))
      
    }}.reduceByKey(_+_)
  ```
 
  
**KPI 3**
  - Find total sales done.
  ```scala
   val result =  data.map{lst =>{
      
      val tokens = lst.split("\t")
      
      ("Total sales done",Double.parseDouble(tokens(4)))  //String Total sales done as key
     
    }}.reduceByKey(_+_)    //all values corresponding to that key are added
  ```



**Running the job**
```spark
bin/spark-submit --class  fullClassName  jarFilePath  input_path   output_path

bin/spark-submit --class KPI_1.productWiseSalesDistrubution  ../Desktop/retail.jar   ../Desktop/Retail_Sample_Data_Set   /output1
```


### Output
**KPI_1**
 ![](output%20Images/output1.PNG)
 
**KPI_2** 
 ![](output%20Images/output2.PNG)
  
**KPI_3**  
  ![](output%20Images/output3.PNG)
  
