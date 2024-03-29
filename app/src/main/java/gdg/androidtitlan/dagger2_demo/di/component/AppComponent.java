/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gdg.androidtitlan.dagger2_demo.di.component;

import android.app.Application;

import dagger.Component;
import gdg.androidtitlan.dagger2_demo.CategoryApplication;
import gdg.androidtitlan.dagger2_demo.category.model.Categories;
import gdg.androidtitlan.dagger2_demo.di.module.AppModule;
import gdg.androidtitlan.dagger2_demo.di.module.InteractorsModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AppModule.class,
        InteractorsModule.class
})
public interface AppComponent {
    void inject(CategoryApplication categoryApplication);

    Categories getFindItemsInteractor();

    /* my issue was caused by forgot this line,
the method name doesn't matter, what matters is the object type AppPref provided in the AppModule
that you want it to be available in the component that declares this component as one of its dependencies*/
    Application exposeApplication();

}
