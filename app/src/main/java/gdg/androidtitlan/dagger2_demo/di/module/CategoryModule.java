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

package gdg.androidtitlan.dagger2_demo.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gdg.androidtitlan.dagger2_demo.category.model.Categories;
import gdg.androidtitlan.dagger2_demo.category.view.ActivityTwo;
import gdg.androidtitlan.dagger2_demo.category.view.SimplePresenter;
import gdg.androidtitlan.dagger2_demo.category.view.presenter.CategoryPresenter;
import gdg.androidtitlan.dagger2_demo.category.view.presenter.Presenter;
import gdg.androidtitlan.dagger2_demo.di.ActivityScope;

@Module
public class CategoryModule {

    private ActivityTwo activityTwo;
    private CategoryPresenter.View view;

    public CategoryModule(CategoryPresenter.View view) {
        this.view = view;
    }

    public CategoryModule(ActivityTwo activityTwo) {
        this.activityTwo = activityTwo;
    }

    @Provides
    @ActivityScope
    public CategoryPresenter.View provideView() {
        return view;
    }

    @Provides
    @ActivityScope
    public ActivityTwo provideActivityTwo() {
        return activityTwo;
    }

    @Provides
    @ActivityScope
    public Presenter providePresenter(CategoryPresenter.View categoryView, Categories categories) {
        return new CategoryPresenter(categoryView, categories);
    }

    @Provides
    @ActivityScope
    public SimplePresenter provideSimplePresenter() {
        return new SimplePresenter();
    }
}
