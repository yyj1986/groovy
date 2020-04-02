import groovy.sql.Sql

class test { 
  static void main(args)  { 
    def sql = Sql.newInstance("jdbc:postgresql://127.0.0.1:5432/test", "yyj", 
          "123", "org.postgresql.Driver") 

    def qrydtl = sql.dataSet("brch_qry_dtl")
    new File("//home/yyj/yyj/helloGroovy/data.csv").splitEachLine(",") {fields ->
        qrydtl.add(
            tran_date: new Date().parse("yyyy- MM-dd", fields[0]),
            timestampl: fields[1],
            acc: fields[2],
            amt: fields[3],
            dr_cr_flag:  fields[4],
            rpt_sum: fields[5]
        )
    }      
  }
} 
/*
sql.eachRow("select * from brch_qry_dtl"){
            println it.acc;
        }

sql.close()
*/


/*

 class test { 
  static void main(args)  { 
    def sql = Sql.newInstance("jdbc:postgresql://127.0.0.1:5432/test", "yyj", 
          "123", "org.postgresql.Driver") 
    def words = sql.dataSet("brch_qry_dtl") 
    words.each { word ->
     println word.acc + " " + word.tran_date + " " + word.amt + " " + word.dr_cr_flag + " " + word.rpt_sum + " " + word.timestampl } 
    words.add(acc:"6042****5274", tran_date:new Date().parse("yyyy- MM-dd", "2019-11-27"), amt:"3115.08",dr_cr_flag:"2", rpt_sum:"快捷",timestampl:"20191127105937") 
  } 
 } 

 

  class DataBase{
    static void main(def args){
        //链接数据库
        def sql = Sql.newInstance("jdbc:postgresql://127.0.0.1:5432/test", "yyj", 
          "123", "org.postgresql.Driver") 

        def db= new DataBase();
    }
  }
  */