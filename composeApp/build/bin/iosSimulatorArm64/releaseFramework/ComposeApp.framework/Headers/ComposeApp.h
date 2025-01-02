#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class ComposeAppDictionaryApi, ComposeAppDictionaryResponse, ComposeAppDictionaryResponseCompanion, ComposeAppKotlinArray<T>, ComposeAppKotlinException, ComposeAppKotlinIllegalStateException, ComposeAppKotlinNothing, ComposeAppKotlinRuntimeException, ComposeAppKotlinThrowable, ComposeAppKotlinx_serialization_coreSerialKind, ComposeAppKotlinx_serialization_coreSerializersModule, ComposeAppSWord, ComposeAppSWordCompanion, ComposeAppSearchApi, ComposeAppSearchResponse, ComposeAppSearchResponseCompanion, ComposeAppWord, ComposeAppWordCompanion, MainViewControllerProvider, UIViewController;

@protocol ComposeAppAudioPlayer, ComposeAppKotlinAnnotation, ComposeAppKotlinIterator, ComposeAppKotlinKAnnotatedElement, ComposeAppKotlinKClass, ComposeAppKotlinKClassifier, ComposeAppKotlinKDeclarationContainer, ComposeAppKotlinx_serialization_coreCompositeDecoder, ComposeAppKotlinx_serialization_coreCompositeEncoder, ComposeAppKotlinx_serialization_coreDecoder, ComposeAppKotlinx_serialization_coreDeserializationStrategy, ComposeAppKotlinx_serialization_coreEncoder, ComposeAppKotlinx_serialization_coreKSerializer, ComposeAppKotlinx_serialization_coreSerialDescriptor, ComposeAppKotlinx_serialization_coreSerializationStrategy, ComposeAppKotlinx_serialization_coreSerializersModuleCollector, ComposeAppPlatform, ComposeAppVoyager_coreScreen;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface ComposeAppBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface ComposeAppBase (ComposeAppBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface ComposeAppMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface ComposeAppMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorComposeAppKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface ComposeAppNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface ComposeAppByte : ComposeAppNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface ComposeAppUByte : ComposeAppNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface ComposeAppShort : ComposeAppNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface ComposeAppUShort : ComposeAppNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface ComposeAppInt : ComposeAppNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface ComposeAppUInt : ComposeAppNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface ComposeAppLong : ComposeAppNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface ComposeAppULong : ComposeAppNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface ComposeAppFloat : ComposeAppNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface ComposeAppDouble : ComposeAppNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface ComposeAppBoolean : ComposeAppNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((swift_name("Voyager_coreScreen")))
@protocol ComposeAppVoyager_coreScreen
@required
@property (readonly) NSString *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AnimatedWord")))
@interface ComposeAppAnimatedWord : ComposeAppBase <ComposeAppVoyager_coreScreen>
- (instancetype)initWithString:(NSString *)string __attribute__((swift_name("init(string:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthApi")))
@interface ComposeAppAuthApi : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)handleLoginCallbackAuthCode:(NSString *)authCode completionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("handleLoginCallback(authCode:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)loginWithCompletionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("login(completionHandler:)")));
@end

__attribute__((swift_name("AudioPlayer")))
@protocol ComposeAppAudioPlayer
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)playAudioDictionaryApi:(ComposeAppDictionaryApi *)dictionaryApi audioFileName:(NSString * _Nullable)audioFileName completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("playAudio(dictionaryApi:audioFileName:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DictionaryApi")))
@interface ComposeAppDictionaryApi : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)close __attribute__((swift_name("close()")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)createAudioWord:(NSString *)word completionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("createAudio(word:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getDictionaryWithCompletionHandler:(void (^)(ComposeAppDictionaryResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getDictionary(completionHandler:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DictionaryResponse")))
@interface ComposeAppDictionaryResponse : ComposeAppBase
- (instancetype)initWithWords:(NSArray<ComposeAppWord *> *)words __attribute__((swift_name("init(words:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppDictionaryResponseCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppDictionaryResponse *)doCopyWords:(NSArray<ComposeAppWord *> *)words __attribute__((swift_name("doCopy(words:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<ComposeAppWord *> *words __attribute__((swift_name("words")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DictionaryResponse.Companion")))
@interface ComposeAppDictionaryResponseCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppDictionaryResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DictionaryScreen")))
@interface ComposeAppDictionaryScreen : ComposeAppBase <ComposeAppVoyager_coreScreen>
- (instancetype)initWithApi:(ComposeAppDictionaryApi *)api audioPlayer:(id<ComposeAppAudioPlayer>)audioPlayer __attribute__((swift_name("init(api:audioPlayer:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FromGreek")))
@interface ComposeAppFromGreek : ComposeAppBase <ComposeAppVoyager_coreScreen>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Greeting")))
@interface ComposeAppGreeting : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)greet __attribute__((swift_name("greet()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeScreen")))
@interface ComposeAppHomeScreen : ComposeAppBase <ComposeAppVoyager_coreScreen>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((swift_name("Platform")))
@protocol ComposeAppPlatform
@required
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IOSPlatform")))
@interface ComposeAppIOSPlatform : ComposeAppBase <ComposeAppPlatform>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IosAudioPlayer")))
@interface ComposeAppIosAudioPlayer : ComposeAppBase <ComposeAppAudioPlayer>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)playAudioDictionaryApi:(ComposeAppDictionaryApi *)dictionaryApi audioFileName:(NSString * _Nullable)audioFileName completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("playAudio(dictionaryApi:audioFileName:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
@interface MainViewControllerProvider : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)mainViewControllerProvider __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) MainViewControllerProvider *shared __attribute__((swift_name("shared")));
- (UIViewController *)create __attribute__((swift_name("create()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SWord")))
@interface ComposeAppSWord : ComposeAppBase
- (instancetype)initWithAudio:(NSString * _Nullable)audio word:(NSString *)word ru:(NSString * _Nullable)ru gender:(NSString * _Nullable)gender number:(NSString * _Nullable)number case:(NSString * _Nullable)case_ conjugation:(NSString * _Nullable)conjugation inclination:(NSString * _Nullable)inclination tense:(NSString * _Nullable)tense regularity:(NSString * _Nullable)regularity __attribute__((swift_name("init(audio:word:ru:gender:number:case:conjugation:inclination:tense:regularity:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppSWordCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppSWord *)doCopyAudio:(NSString * _Nullable)audio word:(NSString *)word ru:(NSString * _Nullable)ru gender:(NSString * _Nullable)gender number:(NSString * _Nullable)number case:(NSString * _Nullable)case_ conjugation:(NSString * _Nullable)conjugation inclination:(NSString * _Nullable)inclination tense:(NSString * _Nullable)tense regularity:(NSString * _Nullable)regularity __attribute__((swift_name("doCopy(audio:word:ru:gender:number:case:conjugation:inclination:tense:regularity:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable audio __attribute__((swift_name("audio")));
@property (readonly, getter=case) NSString * _Nullable case_ __attribute__((swift_name("case_")));
@property (readonly) NSString * _Nullable conjugation __attribute__((swift_name("conjugation")));
@property (readonly) NSString * _Nullable gender __attribute__((swift_name("gender")));
@property (readonly) NSString * _Nullable inclination __attribute__((swift_name("inclination")));
@property (readonly) NSString * _Nullable number __attribute__((swift_name("number")));
@property (readonly) NSString * _Nullable regularity __attribute__((swift_name("regularity")));
@property (readonly) NSString * _Nullable ru __attribute__((swift_name("ru")));
@property (readonly) NSArray<NSString *> *tags __attribute__((swift_name("tags")));
@property (readonly) NSString * _Nullable tense __attribute__((swift_name("tense")));
@property (readonly) NSString *word __attribute__((swift_name("word")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SWord.Companion")))
@interface ComposeAppSWordCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppSWordCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchApi")))
@interface ComposeAppSearchApi : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)searchQuery:(NSString *)query completionHandler:(void (^)(ComposeAppSearchResponse * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("search(query:completionHandler:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResponse")))
@interface ComposeAppSearchResponse : ComposeAppBase
- (instancetype)initWithWord:(ComposeAppSWord *)word query:(NSString *)query __attribute__((swift_name("init(word:query:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppSearchResponseCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppSearchResponse *)doCopyWord:(ComposeAppSWord *)word query:(NSString *)query __attribute__((swift_name("doCopy(word:query:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *query __attribute__((swift_name("query")));
@property (readonly) ComposeAppSWord *word __attribute__((swift_name("word")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchResponse.Companion")))
@interface ComposeAppSearchResponseCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppSearchResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchScreen")))
@interface ComposeAppSearchScreen : ComposeAppBase <ComposeAppVoyager_coreScreen>
- (instancetype)initWithApi:(ComposeAppSearchApi *)api audioPlayer:(id<ComposeAppAudioPlayer>)audioPlayer __attribute__((swift_name("init(api:audioPlayer:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Trainings")))
@interface ComposeAppTrainings : ComposeAppBase <ComposeAppVoyager_coreScreen>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Word")))
@interface ComposeAppWord : ComposeAppBase
- (instancetype)initWithAudio:(NSString * _Nullable)audio word:(NSString *)word ru:(NSString * _Nullable)ru gender:(NSString * _Nullable)gender number:(NSString * _Nullable)number case:(NSString * _Nullable)case_ conjugation:(NSString * _Nullable)conjugation inclination:(NSString * _Nullable)inclination tense:(NSString * _Nullable)tense voice:(NSString * _Nullable)voice __attribute__((swift_name("init(audio:word:ru:gender:number:case:conjugation:inclination:tense:voice:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppWordCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppWord *)doCopyAudio:(NSString * _Nullable)audio word:(NSString *)word ru:(NSString * _Nullable)ru gender:(NSString * _Nullable)gender number:(NSString * _Nullable)number case:(NSString * _Nullable)case_ conjugation:(NSString * _Nullable)conjugation inclination:(NSString * _Nullable)inclination tense:(NSString * _Nullable)tense voice:(NSString * _Nullable)voice __attribute__((swift_name("doCopy(audio:word:ru:gender:number:case:conjugation:inclination:tense:voice:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable audio __attribute__((swift_name("audio")));
@property (readonly, getter=case) NSString * _Nullable case_ __attribute__((swift_name("case_")));
@property (readonly) NSString * _Nullable conjugation __attribute__((swift_name("conjugation")));
@property (readonly) NSString * _Nullable gender __attribute__((swift_name("gender")));
@property (readonly) NSString * _Nullable inclination __attribute__((swift_name("inclination")));
@property (readonly) NSString * _Nullable number __attribute__((swift_name("number")));
@property (readonly) NSString * _Nullable ru __attribute__((swift_name("ru")));
@property (readonly) NSArray<NSString *> *tags __attribute__((swift_name("tags")));
@property (readonly) NSString * _Nullable tense __attribute__((swift_name("tense")));
@property (readonly) NSString * _Nullable voice __attribute__((swift_name("voice")));
@property (readonly) NSString *word __attribute__((swift_name("word")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Word.Companion")))
@interface ComposeAppWordCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppWordCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AudioPlayerKt")))
@interface ComposeAppAudioPlayerKt : ComposeAppBase

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
+ (void)downloadAudioFileUrl:(NSString *)url destination:(NSString *)destination completionHandler:(void (^)(NSString * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("downloadAudioFile(url:destination:completionHandler:)")));
+ (id<ComposeAppAudioPlayer>)provideAudioPlayer __attribute__((swift_name("provideAudioPlayer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DictionaryScreenKt")))
@interface ComposeAppDictionaryScreenKt : ComposeAppBase
+ (NSString *)decodeUnicodeInput:(NSString *)input __attribute__((swift_name("decodeUnicode(input:)")));
+ (NSString *)encodeForUrlInput:(NSString *)input __attribute__((swift_name("encodeForUrl(input:)")));
+ (NSArray<NSArray<ComposeAppWord *> *> *)paginateVocabularyWords:(NSArray<ComposeAppWord *> *)words itemsPerPage:(int32_t)itemsPerPage __attribute__((swift_name("paginateVocabulary(words:itemsPerPage:)")));
+ (NSString *)transformAudioPathAudioPath:(NSString *)audioPath __attribute__((swift_name("transformAudioPath(audioPath:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FromGreekKt")))
@interface ComposeAppFromGreekKt : ComposeAppBase
@property (class, readonly) NSString *word1 __attribute__((swift_name("word1")));
@property (class, readonly) NSString *word2 __attribute__((swift_name("word2")));
@property (class, readonly) NSString *word3 __attribute__((swift_name("word3")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeScreenKt")))
@interface ComposeAppHomeScreenKt : ComposeAppBase
@property (class, readonly) id<ComposeAppAudioPlayer> audioPlayer __attribute__((swift_name("audioPlayer")));
@property (class, readonly) ComposeAppDictionaryApi *dapi __attribute__((swift_name("dapi")));
@property (class, readonly) ComposeAppSearchApi *sapi __attribute__((swift_name("sapi")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform_iosKt")))
@interface ComposeAppPlatform_iosKt : ComposeAppBase
+ (id<ComposeAppPlatform>)getPlatform __attribute__((swift_name("getPlatform()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SearchScreenKt")))
@interface ComposeAppSearchScreenKt : ComposeAppBase
@property (class, readonly) ComposeAppDictionaryApi *dictionaryApi __attribute__((swift_name("dictionaryApi")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface ComposeAppKotlinThrowable : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (ComposeAppKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface ComposeAppKotlinException : ComposeAppKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface ComposeAppKotlinRuntimeException : ComposeAppKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface ComposeAppKotlinIllegalStateException : ComposeAppKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface ComposeAppKotlinCancellationException : ComposeAppKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol ComposeAppKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<ComposeAppKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<ComposeAppKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol ComposeAppKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<ComposeAppKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<ComposeAppKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol ComposeAppKotlinx_serialization_coreKSerializer <ComposeAppKotlinx_serialization_coreSerializationStrategy, ComposeAppKotlinx_serialization_coreDeserializationStrategy>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface ComposeAppKotlinArray<T> : ComposeAppBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(ComposeAppInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<ComposeAppKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol ComposeAppKotlinx_serialization_coreEncoder
@required
- (id<ComposeAppKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<ComposeAppKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<ComposeAppKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol ComposeAppKotlinx_serialization_coreSerialDescriptor
@required

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSArray<id<ComposeAppKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSArray<id<ComposeAppKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) ComposeAppKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol ComposeAppKotlinx_serialization_coreDecoder
@required
- (id<ComposeAppKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<ComposeAppKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (ComposeAppKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol ComposeAppKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol ComposeAppKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<ComposeAppKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface ComposeAppKotlinx_serialization_coreSerializersModule : ComposeAppBase

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<ComposeAppKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<ComposeAppKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<ComposeAppKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ComposeAppKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ComposeAppKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol ComposeAppKotlinAnnotation
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface ComposeAppKotlinx_serialization_coreSerialKind : ComposeAppBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol ComposeAppKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<ComposeAppKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface ComposeAppKotlinNothing : ComposeAppBase
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol ComposeAppKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<ComposeAppKotlinKClass>)kClass provider:(id<ComposeAppKotlinx_serialization_coreKSerializer> (^)(NSArray<id<ComposeAppKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<ComposeAppKotlinKClass>)kClass serializer:(id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<ComposeAppKotlinKClass>)baseClass actualClass:(id<ComposeAppKotlinKClass>)actualClass actualSerializer:(id<ComposeAppKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<ComposeAppKotlinKClass>)baseClass defaultDeserializerProvider:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<ComposeAppKotlinKClass>)baseClass defaultDeserializerProvider:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<ComposeAppKotlinKClass>)baseClass defaultSerializerProvider:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol ComposeAppKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol ComposeAppKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol ComposeAppKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol ComposeAppKotlinKClass <ComposeAppKotlinKDeclarationContainer, ComposeAppKotlinKAnnotatedElement, ComposeAppKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
