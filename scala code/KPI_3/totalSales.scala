package KPI_3

import org.apache.spark.sql.SparkSession
import java.lang.Double


object totalSales {
  
  def main(args:Array[String])
  {
    
    val spark = SparkSession.builder().appName("KPI 3").getOrCreate()
    
    val data = spark.read.textFile(args(0)).rdd
    
    val result =  data.map{lst =>{
      
      val tokens = lst.split("\t")
      
      ("Total sales done",Double.parseDouble(tokens(4)))
      
      
      
    }}.reduceByKey(_+_)
      
      
      
    
    result.saveAsTextFile(args(1))
    
    spark.stop
    
    
  }
  
  
  
  
}