package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Find and return items from a collections whose total value equals
 * the requested amount.
 *
 * @author Pichaaun Popukdee
 */
public interface WithdrawStrategy {
        /**
         * @param amount is the amount of money to withdraw , with currency
         * @param items the contents that are available for possible withdraw.
         *              must not be null , but may be an empty list.
         *              This list is not modified.
         * @return if a solution is found return list containing references from the money parameter (List)
         *          whose sum equals to amount
         *         if the solution not found , return emptyList;
         */
        public List<Valuable> withdraw (Valuable amount , List<Valuable> items) ;
}
