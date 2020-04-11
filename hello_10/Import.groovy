import groovy.sql.Sql

    def sql = Sql.newInstance("jdbc:postgresql://127.0.0.1:5432/test", "yyj", 
          "123", "org.postgresql.Driver") 

    sql.execute """
      drop table  brch_qry_dtl;
    """

    sql.execute """
      create table brch_qry_dtl (
        acc character varying(19), 
        tran_date date, 
        amt numeric(16,2), 
        dr_cr_flag integer, 
        rpt_sum character varying(8), 
        timestampl character varying(14)
      );
  """

    sql.connection.autoCommit = false

    new File("//home/yyj/yyj/helloGroovy/data.csv").splitEachLine(",") {fields ->
            sql.execute """
               INSERT INTO brch_qry_dtl (tran_date, timestampl, acc, amt, dr_cr_flag, rpt_sum)
                VALUES (?::date, ?, ?, ?, ?, ?);
            """, [fields[0], fields[1], fields[2], fields[3].toFloat(), fields[4].toInteger(), fields[5]]
    }  


    sql.commit()    

