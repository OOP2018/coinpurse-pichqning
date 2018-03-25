package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Withdraw strategy by using normal logic like used in purse.
 * @author Pichaaun Popukdee
 */

public class GreedyWithdraw implements WithdrawStrategy {

    private Comparator<Valuable> comp = new ValueComparator();

    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
        if (amount == null) return null;
        if (amount.getValue() < 0) {
            return null;
        }
        double amountNeededToWithdraw = amount.getValue();
        List<Valuable> templist = new ArrayList<>();
        items.sort(comp);

        for (int k = items.size() - 1; k >= 0; k--) {
            if (amountNeededToWithdraw == 0) break;
            if (amountNeededToWithdraw > 0 && amount.getCurrency().equalsIgnoreCase(items.get(k).getCurrency())) {
                if (amountNeededToWithdraw - items.get(k).getValue() >= 0) {
                    amountNeededToWithdraw -= items.get(k).getValue();
                    templist.add(items.get(k));
                    items.remove(k);
                }
            }
        }


        if (amountNeededToWithdraw > 0) {
            items.addAll(templist);
            return null;
        }
        return templist;
    }
}
