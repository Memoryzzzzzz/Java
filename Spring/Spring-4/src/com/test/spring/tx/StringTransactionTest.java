package com.test.spring.tx;

import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void testTeansactionlPropagation() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    // 用户AA的账户余额减去100
    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 100);
    }

    // isbn为1001的库存减一
    @Test
    public void testBookShopDapUpdateBookStock() {
        bookShopDao.updateBookStock("1001");
    }

    // 获取isbn为1001的价格
    @Test
    public void test() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

}
