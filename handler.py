import json
import boto3

translate = boto3.client('translate')

def lambda_handler(event, context):
    print(f'{event.get('body')}')
    request_body = json.loads(event.get('body'))
    statusCode = None
    response_body = None
    try:
        target_lang = request_body['target_language']
        text = request_body['text']
        result = translate.translate_text(
            Text=text,
            SourceLanguageCode="auto",
            TargetLanguageCode=target_lang
        )
        print(f"result: {result}")
        statusCode = 200
        response_body = {
            "result": result.get("TranslatedText")
        }
        

    except Exception as e:
        statusCode = 500
        response_body = {
            "message": e.__str__()
        }
        print(e.__str__())
    finally:
        print(statusCode)
        print(response_body)
        return {
            'statusCode': statusCode,
            'headers': 'application/json',
            'body': json.dumps(response_body, ensure_ascii=False).encode("utf8")
        }