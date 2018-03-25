package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Withraw strategy by using recursive step .
 * @author Pichaaun Popukdee
 */
public class RecursiveWithdraw implements WithdrawStrategy {
    private Comparator<Valuable> comp = new ValueComparator();
    private List<Valuable> list = new ArrayList<>();

    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
        items.sort(comp);
        return helper(amount.getValue(),items , amount);
    }

    private List<Valuable> helper(double value, List<Valuable> items , Valuable amount) {
        if (value == 0) return new ArrayList<>();
        if (items.size() == 0)
            if (value != 0) return null;
        if (value < 0) return null;
        List<Valuable> tempList = helper(value - items.get(0).getValue(), items.subList(1, items.size()), amount);
        if (tempList == null) return helper(value, items.subList(1, items.size()), amount);
        else {
            tempList.add(items.get(0));
            items.remove(0);
            return tempList;
        }
    }

//    @Override
//    public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
//        items.sort(comp);
//        if (helper(0,items,amount.getValue(),amount)) return list;
//        return null;
//    }
//        if (start >= items.size()) return target==0;
//        if (helper(start+1 , items , target - items.get(start).getValue(),amount) ) {
//            if(!amount.getCurrency().equals(items.get(start).getCurrency())) return false;
//            list.add(items.get(start));
//            items.remove(start);
//            return true;
//        }
//        return helper(start+1,items,target, amount);
//    }

}
