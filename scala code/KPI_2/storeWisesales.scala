package KPI_2

import org.apache.spark.sql.SparkSession
import java.lang.Double


object storeWisesales {
  
  def main(args: Array[String])
  {
    
    val spark = SparkSession.builder().appName("KPI 2").getOrCreate();
    
    val data = spark.read.textFile(args(0)).rdd;
    
    val result = data.map{line=>{
     
     val tokens = line.split("\t")
     
     (tokens(2), Double.parseDouble(tokens(4)))
      
      
      
    }}.reduceByKey(_+_)
    
    
    result.saveAsTextFile(args(1));
    spark.stop
    
    
    
    
    
    
    
    
    
    
    
  }
  
  
  
  
}