#import "Fibo.h"
#import <Cordova/CDV.h>

@implementation Fibo

- (void) get:(CDVInvokedUrlCommand*)command {
  NSString *callbackId = command.callbackId;

  // Acquire a reference to the local UIApplication singleton
  UIApplication* app = [UIApplication sharedApplication];

  if (![app isIdleTimerDisabled]) {
    [app setIdleTimerDisabled:true];
  }
  CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
  [self.commandDelegate sendPluginResult:result callbackId:callbackId];
}

@end