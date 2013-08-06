package com.yammer.tenacity.core.helper;

import com.google.common.base.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This compound object can be created either with the Result value see {@link #create(Object)}
 * or with a Fallback value see {@link #failedCommand(Object)}
 * It behaves similar to Google Guava's Optional, throwing an IllegalStateException when
 * an absent value is queried.
 *
 * @param <Result> The generic type of the Object returned when creating a successful instance
 * @param <Fallback> The generic type of the Object returned when creating a failed instance
 */
public class ResultWithFallback<Result, Fallback> {

    private final Optional<Result> result;
    private final Optional<Fallback> fallback;

    private ResultWithFallback(Optional<Result> result, Optional<Fallback> fallback){
        this.result = result;
        this.fallback = fallback;
    }

    /**
     * @param fallback The value of the fallback object
     * @param <Result> The expected type of the operation if successful
     * @param <Fallback> The expected type used as the fallback
     * @return A composite object holding only the fallback value
     */
    public static <Result,Fallback> ResultWithFallback<Result,Fallback> failedCommand(Fallback fallback){
        return new ResultWithFallback<>(Optional.<Result>absent(), Optional.of(checkNotNull(fallback)));
    }

    /**
     *
     * @param result The expected value of a successful operation
     * @param <Result> The expected type of the operation
     * @param <Fallback> The expected type of the fallback
     * @return A composite object holding only the result value
     */
    public static <Result,Fallback> ResultWithFallback<Result,Fallback> create(Result result){
        return new ResultWithFallback<>(Optional.of(checkNotNull(result)), Optional.<Fallback>absent());
    }

    /**
     *
     * @return true if the Result value is present, false if only the Fallback value is available.
     */
    public boolean isPresent(){
        return result.isPresent();
    }

    /**
     *
     * @return The expected Result value on success;
     */
    public Result getResult(){
        return result.get();
    }


    /**
     *
     * @return true if the fallback value is present.
     */
    public boolean hasFallback(){
        return fallback.isPresent();
    }

    /**
     *
     * @return The expected Fallback value on failure;
     */
    public Fallback getFallback(){
        return fallback.get();
    }
}

