//package com.ecovacs.baselibrary.command;
//
//import rx.functions.Action0;
//import rx.functions.Action1;
//import rx.functions.Func0;
//
///**
// * Created by liang.liu on 2018/3/13.
// */
//
//public class ReplayCommand<T> {
//
//    private Action0 execute0;
//    private Action1<T> execute1;
//
//    private Func0<Boolean> canExecute0;
//
//    public ReplayCommand(Action0 execute0) {
//        this.execute0 = execute0;
//    }
//
//    public ReplayCommand(Action1<T> execute1) {
//        this.execute1 = execute1;
//    }
//
//    public ReplayCommand(Action0 execute0, Func0<Boolean> canExecute0) {
//        this.execute0 = execute0;
//        this.canExecute0 = canExecute0;
//    }
//
//    public ReplayCommand(Action1<T> execute1, Func0<Boolean> canExecute0) {
//        this.execute1 = execute1;
//        this.canExecute0 = canExecute0;
//    }
//
//    public void execute() {
//        if (execute0 != null && canExecute0()) {
//            execute0.call();
//        }
//    }
//
//    private boolean canExecute0() {
//        if (canExecute0 == null) {
//            return true;
//        }
//        return false;
//    }
//
//    public void execute(T parameter) {
//        if (execute1 != null && canExecute0()) {
//            execute1.call(parameter);
//        }
//    }
//}
