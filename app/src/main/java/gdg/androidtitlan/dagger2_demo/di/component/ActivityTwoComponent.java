package gdg.androidtitlan.dagger2_demo.di.component;

import dagger.Component;
import gdg.androidtitlan.dagger2_demo.category.view.ActivityTwo;
import gdg.androidtitlan.dagger2_demo.di.ActivityScope;
import gdg.androidtitlan.dagger2_demo.di.module.CategoryModule;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = CategoryModule.class)
public interface ActivityTwoComponent {

    void inject(ActivityTwo activityTwo);
}
