package com.mine.read

import groovy.sql.Sql

class DB {
    Sql sql

    DB() {
        sql = Sql.newInstance("jdbc:postgresql://127.0.0.1:5432/test", "yyj", 
          "123", "org.postgresql.Driver") 
    }

    def getqrydtl(String trandate) {
        List qry_dtl = sql.rows("""
            select * from brch_qry_dtl
            where tran_date = cast(? as date) 
        """, trandate)

        List results = []
        qry_dtl.each() { 
            def x = new qrydtl()
            x.acc = it.acc
            x.trandate = it.tran_date
            x.amt = it.amt
            x.rptsum = it.rpt_sum
            x.dr_cr_flag = it.dr_cr_flag
            x.timestamp1 = it.timestamp1
            results += x
        }
        return results
    }
}
