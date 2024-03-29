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

import dagger.Component;
import gdg.androidtitlan.dagger2_demo.category.view.activity.CategoryActivity;
import gdg.androidtitlan.dagger2_demo.category.view.presenter.Presenter;
import gdg.androidtitlan.dagger2_demo.di.ActivityScope;
import gdg.androidtitlan.dagger2_demo.di.module.CategoryModule;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = CategoryModule.class)
public interface CategoryComponent {
  void inject(CategoryActivity categoryActivity);

  Presenter getMainPresenter();
}
