//package com.ecovacs.baselibrary.command;
//
//import rx.functions.Func0;
//import rx.functions.Func1;
//
///**
// * Created by liang.liu on 2018/3/13.
// */
//
//public class ResponseCommand<T, R> {
//
//    private Func0<R> execute0;
//    private Func1<T, R> execute1;
//
//    private Func0<Boolean> canExecute0;
//
//    public ResponseCommand(Func0<R> execute0) {
//        this.execute0 = execute0;
//    }
//
//    public ResponseCommand(Func1<T, R> execute1) {
//        this.execute1 = execute1;
//    }
//
//    public ResponseCommand(Func0<R> execute0, Func0<Boolean> canExecute0) {
//        this.execute0 = execute0;
//        this.canExecute0 = canExecute0;
//    }
//
//    public ResponseCommand(Func1<T, R> execute1, Func0<Boolean> canExecute0) {
//        this.execute1 = execute1;
//        this.canExecute0 = canExecute0;
//    }
//
//    public R execute() {
//        if (execute0 != null && canExecute0()) {
//            return execute0.call();
//        }
//        return null;
//    }
//
//    private boolean canExecute0() {
//        if (canExecute0 == null) {
//            return true;
//        }
//        return canExecute0.call();
//    }
//
//
//    public R execute(T parameter) {
//        if (execute1 != null && canExecute0()) {
//            return execute1.call(parameter);
//        }
//        return null;
//    }
//}
