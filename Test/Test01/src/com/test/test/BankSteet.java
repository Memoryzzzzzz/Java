package com.test.test;

/**
 * 实现
 * 上架时校验是否开市
 * 输出上架成功或失败
 * 下架时校验是否开市
 * 输出下架成功或失败
 */
public class BankSteet implements SteetInterface,marketInterface {

    /**
     * 检测是否开市
     */
    @Override
    public boolean openMarket() {
        return true;
    }

    /**
     * 检测是否闭市
     */
    @Override
    public boolean closeMarket() {
        return true;
    }

    /**
     * 检测是否上架成功
     */
    @Override
    public void upperShelf(Steet steet) {
        if(openMarket()){
            System.out.println("上架成功");
        }else{
            System.out.println("上架失败");
        }
    }

    /**
     * 检测是否下架成功
     */
    @Override
    public void lowerShelf(Steet steet) {
        if(closeMarket()){
            System.out.println("下架成功");
        }else{
            System.out.println("下架失败");
        }
    }

}
