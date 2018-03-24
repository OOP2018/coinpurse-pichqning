package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public interface WithdrawStrategy {
        public List<Valuable> withdraw (Valuable amount , List<Valuable> items) ;
}
