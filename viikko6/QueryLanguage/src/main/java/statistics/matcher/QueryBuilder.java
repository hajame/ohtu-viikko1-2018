/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author hameha
 */
public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int number, String stats) {
        this.matcher = new And(matcher, new HasAtLeast(number, stats));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int number, String stats) {
        this.matcher = new And(matcher, new HasFewerThan(number, stats));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    public Matcher build() {
        Matcher memory = this.matcher;
        this.matcher = new All();
        return memory;
    }
}
