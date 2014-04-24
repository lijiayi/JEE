package de.spqrinfo.jee.cryptsingleton.module;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CryptBeanTest {

    private CryptBean cryptBean;

    @Before
    public void before() {
        final KeyBean keyBean = new KeyBean();
        keyBean.init();

        this.cryptBean = new CryptBean(keyBean);
        this.cryptBean.init();
    }

    @Test
    public void encryptDecryptTest() {
        final String plainText = "Hello, World!";

        final String cipherText = this.cryptBean.encrypt(plainText);
        System.out.println(cipherText);

        final String plainText2 = this.cryptBean.decrypt(cipherText);
        Assert.assertEquals("encryption roundtrip", plainText, plainText2);
    }



    @Test
    public void shortTextEncryptDecryptTest() {
        final String plainText = "hello";

        final String cipherText = this.cryptBean.encrypt(plainText);
        System.out.println(cipherText);
        Assert.assertEquals("Short text encryption roundtrip", plainText, this.cryptBean.decrypt(cipherText));
    }

    @Test
    public void longTextEncryptDecryptTest() {
        final String plainText = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,";

        final String cipherText = this.cryptBean.encrypt(plainText);
        System.out.println(cipherText);
        Assert.assertEquals("long text encryption roundtrip", plainText, this.cryptBean.decrypt(cipherText));
    }
}
