package com.jackpan.effective;

import java.util.Objects;

/**
 * NyPizza.
 *
 * @author jackpan
 * @version v1.0 2020/11/15 09:14
 */
public class NyPizza extends Pizza {

    public enum Size{ SMALL, MEDIUM, LAGER }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
