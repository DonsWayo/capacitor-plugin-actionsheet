declare module '@capacitor/core' {
  interface PluginRegistry {
    ActionSheet: ActionSheetPlugin;
  }
}

export interface ActionSheetPlugin {
  showActionSheet(options: { values: string[], title: string}): Promise<{ value: string }>;
}
