package KPI_1

import java.lang.Double
import org.apache.spark.sql.SparkSession


object productWiseSalesDistribution {
  
 def main(args: Array[String])
 {
   
   val spark = SparkSession.builder().appName("product sales distribution").getOrCreate()
   
   val data = spark.read.textFile(args(0)).rdd
   
   val breaking  = data.map{lst => 
     { 
       val tokens = lst.split("\t")
      
       val product = tokens(3)
       val sales = tokens(4)
      (product,Double.parseDouble(sales))
       
       
     }}
     .reduceByKey(_+_)
   
     
   breaking.saveAsTextFile(args(1))
   
   spark.stop
   
   
   
   
   
 }
  
  
  
  
}