package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecursiveWithdraw implements WithdrawStrategy {
    private Comparator<Valuable> comp = new ValueComparator();
    private List<Valuable> list = new ArrayList<>();

    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
        items.sort(comp);
        if (helper(0,items,amount.getValue(),amount)) return list;
        return null;
    }

    private boolean helper(int start, List<Valuable> items, double target , Valuable amount) {
        if (start >= items.size()) return target==0;
        if (helper(start+1 , items , target - items.get(start).getValue(),amount) ) {
            if(!amount.getCurrency().equals(items.get(start).getCurrency())) return false;
            list.add(items.get(start));
            items.remove(start);
            return true;
        }
        return helper(start+1,items,target, amount);
    }

}
