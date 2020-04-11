import com.mine.read.*

class App {
    static void main(String[] args) {
        def results = DB.getqrydtl('2020-04-10')
        results.each() { x ->
            println "${x.acc}, ${x.amt}, ${x.rptsum}, ${x.dr_cr_flag}, ${x.timestamp1},${x.tranDate}"
        }
    }
}
