package com.example.demoeurekaclient.common;

import java.util.List;
import java.util.Set;

import com.example.demoeurekaclient.common.register.Iregister;
import com.example.demoeurekaclient.common.register.RegisterFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhanglirui
 * @date 2020/11/4 11:31 上午
 */
public class CQRSBootstrap {

    private List<String> packages;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    @Autowired
    private RegisterFactory registerFactory ;

    public void init(){
        // todo 获取指定包下的对象
        Set<Class<?>> classSet = scanConfiguredPackages();
        registerBeans(classSet);

    }

    private void registerBeans(Set<Class<?>> classSet) {
        for (Class<?> cla:classSet) {
            Iregister register = registerFactory.getRegister(cla);
            if(register != null){
                register.doRegister(cla);
            }
        }
    }

    public Set<Class<?>> scanConfiguredPackages() {

        /*if (CollectionUtils.isEmpty(packages)) {
            throw new CommandException("packages is not specified");
        }

        String[] pkgs = new String[packages.size()];
        ClassPathScanHandler handler = new ClassPathScanHandler(packages.toArray(pkgs));

        Set<Class<?>> classSet = new TreeSet<Class<?>>(new ClassNameComparator());
        for (String pakName : packages) {
            classSet.addAll(handler.getPackageAllClasses(pakName, true));
        }
        return classSet;*/
        return null;
    }
}
