import { WebPlugin } from '@capacitor/core';
import { ActionSheetPlugin } from './definitions';

export class ActionSheetWeb extends WebPlugin implements ActionSheetPlugin {
  constructor() {
    super({
      name: 'ActionSheet',
      platforms: ['web'],
    });
  }
  //@ts-ignore
  showActionSheet(options: { values: string[]; title: string; }): Promise<{ value: string; }> {
    throw new Error("Method not implemented.");
  }
}

const ActionSheet = new ActionSheetWeb();

export { ActionSheet };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(ActionSheet);
