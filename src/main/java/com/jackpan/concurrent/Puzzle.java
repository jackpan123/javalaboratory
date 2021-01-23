package com.jackpan.concurrent;

import java.util.Set;

/**
 * @author jackpan
 * @version v1.0 2021/1/23 15:07
 */
public interface Puzzle <P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
